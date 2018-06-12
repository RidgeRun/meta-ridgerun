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

- Once you have access to the repository, please open gst-webrtc_1.8.1.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

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

- Once you have access to the repository, please open gst-rtspsink_0.5.bb in **$YOCTO_DIRECTORY/sources/meta-ridgerun/recipes-multimedia/gstreamer/**

- Modify SRC_URI with the correct gst-rtspsink URL by changing **<Customer-Directory>** with your own.

- Make sure you have added your ssh key to your GitLab account and the GitLab key is added to your list of known hosts on the PC.

- Finally build recipe
```
bitbake gst-rtspsink
```
- For more information:
    https://developer.ridgerun.com/wiki/index.php?title=GstRtspSink_-_Building_the_plug-in#Building_on_Yocto



