SUMMARY = "Gstreamer 1.0 motion detect plugin"
DESCRIPTION = "GStreamer element used to detect motion in video streams by background substraction"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Camera_Based_Motion_Detection"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://${THISDIR}/../../COPYING;md5=d28c53f3a5ec6efa235f27afaaa18be1"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base glib-2.0 glibc"

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
# Note: This SRC_URI points to RidgeRun's internal repository. Should
# replace it with the repository URI provided to them upon purchase of the plugin.
SRC_URI = "git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-motion-detect-1-0.git;protocol=ssh;branch=${SRCBRANCH}"

S = "${WORKDIR}/git/src"

FILES:${PN} += " ${libdir}/gstreamer-1.0/libgstmotiondetect.so"

inherit autotools pkgconfig gettext

do_install:append() {
	rm -f ${D}${libdir}/gstreamer-1.0/libgstmotiondetect.a
}
