DESCRIPTION = "GStreamer UVC sink 1.0"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server libguvc"

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/libguvc.git;protocol=ssh;branch=${SRCBRANCH};subpath=gst-uvc-sink-1.0;lfs=0"


S = "${WORKDIR}/gst-uvc-sink-${PV}"

FILES:${PN} += "${libdir}/gstreamer-1.0/libgstuvcsink.so "

inherit autotools pkgconfig gettext

do_configure() {
    ${S}/autogen.sh
    oe_runconf
}