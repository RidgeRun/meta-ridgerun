SUMMARY = "Gstreamer 1.0 motion detect plugin"
DESCRIPTION = "GStreamer element used to detect motion in video streams by background substraction"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Camera_Based_Motion_Detection"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=152bda62bf553a99a8aff727654bb4c7"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base glib-2.0 glibc"

SRCBRANCH ?= "master"
SRCREV = "ef0a8a6b78a92c9b2f861873e13722c2e6ef2df1"
SRC_URI = " git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-motiondetect.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/src"

FILES_${PN} += " ${libdir}/gstreamer-1.0/libgstmotiondetect.so"

inherit autotools pkgconfig gettext

do_install_append() {
	rm ${D}${libdir}/gstreamer-1.0/libgstmotiondetect.a
}
