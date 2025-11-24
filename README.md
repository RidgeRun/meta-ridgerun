# meta-ridgerun

Ridgerun yocto layer containing RidgeRun commonly used packages

## Adding meta-ridgerun to your Yocto build

- First you need to copy meta-ridgerun in your **sources** directory
```
cp -r meta-ridgerun $YOCTO_DIRECTORY/sources/
```

- Then add the RidgeRun meta layer to your *bblayers.conf* file. First go to the build configuration directory
```
cd $YOCTO_DIRECTORY/build/conf/
```

- Open the *bblayers.conf* file and add the RidgeRun meta layer path **$YOCTO_DIRECTORY/sources/meta-ridgerun** to **BBLAYERS**

- With these steps the meta-ridgerun layer was added correctly

## Define your target platform

- Go to your yocto directory and export the machine used. For example:
```
export MACHINE=zcu106-zynqmp
```

## Building Gst-Shark and Gstreamer Deamon

- Finally build recipes
```
bitbake gstd gst-shark
```

## Building Gst-WebRTC (Private)

- GstWebRTC is an add-on to RidgeRun's professional SDK. You can purchase GstWebRTC with full source code, from:
    https://www.ridgerun.com/store/GSTWebRTC-p74337777

- Once you have access to the repository, please open gst-webrtc_1.11.2.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-webrtc URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-webrtc
```
- For more information: 
    http://developer.ridgerun.com/wiki/index.php?title=GstWebRTC_-_Building_GstWebRTC#Building_Gst-WebRTC_on_Yocto

## Building Pre-Record (Private)

- Pre-Record is an add-on to RidgeRun's professional SDK. You can purchase Pre-Record with full source code, from:
    https://www.ridgerun.com/store/GStreamer-Pre-Record-Element-p59350608

- Once you have access to the repository, please open gst-pre-trigger_1.0.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-pre-record URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-pre-record
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=GStreamer_pre-record_element#Building_on_Yocto

## Building Gst-Emboverlay (Private)

- Embedded Overlay is an add-on to RidgeRun's professional SDK. You can purchase Embedded Overlay with full source code, from:
    https://www.ridgerun.com/store/GStreamer-Fast-Text-Graphics-Overlay-p59350604

- Once you have access to the repository, please open gst-emboverlay_1.0.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-emboverlay URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-emboverlay
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=Fast_GStreamer_overlay_element#Building_on_Yocto


## Building Gst-RtspSink (Private)

- RTSP Sink is a GStreamer element which permits high performance streaming to multiple computers using the RTSP / RTP protocols. You can purchase Gst-RtspSink with full source code, from:
    https://www.ridgerun.com/store/GStreamer-multi-stream-mulit-channel-RTSP-server-element-p59350595

- Once you have access to the repository, please open gst-rtsp-sink_0.5.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-rtspsink URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-rtsp-sink
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=GstRtspSink_-_Building_the_plug-in#Building_on_Yocto


## Building Gst-Qt-Overlay (Private)

- QtOverlay is a GStreamer element that renders qt graphics on a video stream. You can purchase Gst-Qt-overlay with full source code, from:
    https://www.ridgerun.com/store/GStreamer-QT-Overlay-p84694153

- Once you have access to the repository, please open gst-qt-overlay_1.0.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-qt-overlay URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-qt-overlay
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=Gstreamer_QT_Overlay#Building_GstQtOverlay_on_Yocto

## Building Gst-Interpipes (Public)

- GstInterpipe is a Gstreamer plug-in that allows communication between two independent pipelines. The plug-in consists of two elements, interpipesink and interpipesrc

- To build the recipe:
```
bitbake gst-interpipe
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=GstInterpipe

## Building Gst-opencl (Private)

GstOpenCL is a GStreamer framework enabling easy OpenCL algorithm integration into GStreamer pipelines. The framework consists of a series of base classes and utils abstracting the complexity of both OpenCL and GStreamer.

- To build the recipe:
```
bitbake gst-opencl
```
- For more information:
    https://www.ridgerun.com/gstopencl

## Building Gst-SEI (Private)

- GstSEI is a GStreamer element to insert and extract metadata on NAL Units
    https://shop.ridgerun.com/products/gstseimetadata

- Once you have access to the repository, please open gst-sei_0.2.2.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-sei URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-sei
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=GstSEIMetadata

### iMX6 build

If you are building for an iMX6 board, make sure you have the **imx-gst1.0-plugin** and **gstreamer1.0-plugins-imx** packages.
The recipies should be in the [meta-freescale](https://git.yoctoproject.org/cgit/cgit.cgi/meta-freescale/tree/recipes-multimedia/gstreamer?h=master) layer.

### QCOM RB5 build
The following appends were created to fix RB5 QRB5165.LU2.0_20250723.2230_debug build: recipes-toolchain/ubuntu/python3-ubuntu_%.bbappend, recipes-core/expat/expat_%.bbappend.
The following appends were created to support RidgeRun Video Stabilizer on RB5: recipes-multimedia/gstreamer/gstreamer1.0-plugins-qti-oss-qmmfsrc.bbappend, recipes-multimedia/gstreamer/gstreamer1.0-plugins-qti-oss-vtransform/gstreamer1.0-plugins-qti-oss-vtransform.bbappend. Both appends depend on recipes-multimedia/gstreamer/gstcameradrivermeta/gstcameradrivermeta_1.0.bb.