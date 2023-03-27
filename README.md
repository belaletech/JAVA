# JAVA

Java
Overview
The following repo contains examples for OpenFin's Java.

Guidelines
Run the example of connecting to OpenFin and creating applications

Clone this repository

Go to release directory and start run.bat

Once the java app starts, click on Start button, which should start OpenFin Runtime. The java app will wait and try to connect to OpenFin Runtime.

Once OpenFin Runtime is started and Java app connects successfully, "Create Application" button is enabled. You can click on the button to bring up a dialog for entering configuration of any HTML5 app. By default, the dialog is pre-populated with configuration for Hello OpenFin demo app.

You can use buttons in Window Control section to move and re-size HTML5 window of Hello OpenFin app.

Click "Create Application" button, which should start a dialog with all the fields pre-populated for our Hello OpenFin demo HTML5 application. Just click on "Create" button.

After Hello OpenFin starts, you can use the buttons under Window Control of Java app to control Hello OpenFin window.

Source Code Review
Source code for the example is located in /src/main/java/com/openfin/desktop/demo/OpenFinDesktopDemo.java. The followings overview of how it communicates with OpenFin Runtime with API calls supported by the Java adapter:

Create connection object:
	this.desktopConnection = new DesktopConnection("OpenFinDesktopDemo");
This code just creates an instance of DesktopConnection and it does not try to connect to runtime.

Launch and connect to stable version of OpenFin runtime:
	// create an instance of RuntimeConfiguration and configure Runtime by setting properties in RuntimeConfiguration
	this.runtimeConfiguration = new RuntimeConfiguration();
	// launch and connect to OpenFin Runtime
	desktopConnection.connect(this.runtimeConfiguration, listener, 10000);
listener is an instance of DesktopStateListener which provides callback on status of connections to runtime.

Create new application when clicking on Create App:
   Application app = new Application(options, desktopConnection, new AckListener() {
   	@Override
   	public void onSuccess(Ack ack) {
   		Application application = (Application) ack.getSource();
   		application.run();   // run the app
   	}
   	@Override
   	public void onError(Ack ack) {
   	}
   });
options is an instance of ApplicationOptions, which is populated from App Create dialog. AckListener interface provides callback for the operation.

Once the application is created successfully, you can take actions on its window:

Change opacity:
	WindowOptions options = new WindowOptions();
	options.setOpacity(newOpacityValue);
	application.getWindow().updateOptions(options, null);
Change Window size
	application.getWindow().resizeBy(10, 10, "top-left");
Publishes messages to a topic with InterApplicationBus
	org.json.JSONObject message = createSomeJsonMessage();
	desktopConnection.getInterApplicationBus().publish("someTopic", message);
Subscribes to a topic with InterApplicationBus
	desktopConnection.getInterApplicationBus().subscribe("*", "someTopic", new BusListener() {
		public void onMessageReceived(String sourceUuid, String topic, Object payload) {
			JSONObject message = (JSONObject) payload;
		}
	});
Run the example of embedding HTML5 application into a Java Swing window
Clone this repository

Go to release directory and start embed.bat ( the default embedded url is https://openfin.co. Pass the url you wish to load if you want something different e.g. embed.bat https://www.mydomain.com )

Once the java app starts, click on "Launch OpenFin" button, which should start OpenFin Runtime and embed the OpenFin application that points to https://openfin.co (or your custom url if you specified one)

Click "Shutdown OpenFin" button to close HTML5 application and the Java Swing window

If there is a problem rendering the url please check your windows display settings to see ensure scaling is set to 100%.

Source Code Review for embedded OpenFin application
Source code for the example is located in /src/main/java/com/openfin/desktop/demo/WindowEmbedDemo.java

create a canvas and place it where the HTML5 application should be embedded.
	embedCanvas = new java.awt.Canvas();
	panel.add(embedCanvas, BorderLayout.CENTER);
listen to the canvas resize event, and resize embedded HTML5 application accordingly.
	embedCanvas.addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent event) {
	        super.componentResized(event);
	        Dimension newSize = event.getComponent().getSize();
	        try {
	            if (startupHtml5app != null) {
	                startupHtml5app.getWindow().embedComponentSizeChange((int)newSize.getWidth(), (int)newSize.getHeight());
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	});
launch and connect to OpenFin runtime
	this.desktopConnection = new DesktopConnection(appUuid);
	DesktopStateListener listener = new DesktopStateListener() {...};
	RuntimeConfiguration configuration = new RuntimeConfiguration();
	configuration.setRuntimeVersion(desktopVersion);
	desktopConnection.connect(configuration, listener, 60);
create HTML5 application
	ApplicationOptions options = new ApplicationOptions(startupUuid, startupUuid, openfin_app_url);
	WindowOptions mainWindowOptions = new WindowOptions();
	options.setMainWindowOptions(mainWindowOptions);
	DemoUtils.runApplication(options, this.desktopConnection, new AckListener() {...});
embed HTML5 application into the canvas
	startupHtml5app = Application.wrap(this.startupUuid, this.desktopConnection);
	Window html5Wnd = startupHtml5app.getWindow();
	long parentHWndId = Native.getComponentID(this.embedCanvas);
	html5Wnd.embedInto(parentHWndId, this.embedCanvas.getWidth(), this.embedCanvas.getHeight(), new AckListener() {...});
More Info
More information and API documentation can be found at https://openfin.co/java-api/

Disclaimers
This is a starter example and intended to demonstrate to app providers a sample of how to approach an implementation. There are potentially other ways to approach it and alternatives could be considered.
Its possible that the repo is not actively maintained.
License
MIT
