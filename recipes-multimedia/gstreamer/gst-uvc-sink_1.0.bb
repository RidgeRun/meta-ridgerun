DESCRIPTION = "GStreamer UVC sink 1.0"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server libguvc"

SRCBRANCH ?= "yocto-sumo"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/libguvc.git;protocol=ssh;branch=${SRCBRANCH};subpath=gst-uvc-sink-1.0"


S = "${WORKDIR}/gst-uvc-sink-${PV}"

FILES_${PN} += "${libdir}/gstreamer-1.0/libgstuvcsink.so"
FILES_${PN} += "${bindir}/{uvc_uvcsink_yuyv_app,uvc_uvcsink_h264_app,uvc_uvcsink_mjpeg_app}"

inherit autotools pkgconfig gettext

do_configure() {
${S}/autogen.sh
oe_runconf
}