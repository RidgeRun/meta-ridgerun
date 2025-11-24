SUMMARY = "GStreamer Driver Meta"
DESCRIPTION = "Driver Meta for GStreamer used in RidgeRun's Video Stabilizer"
LICENSE = "LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"


BRANCH ?= "master"
SRC_URI = "git://gitlab.ridgerun.com/open/gstreamer/ridgerun-video-stabilization/gstcameradrivermeta.git;protocol=https;branch=${BRANCH}"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"
inherit pkgconfig

EXTRA_OEMAKE = "\
    PREFIX=${prefix} \
    INC_DIR=${includedir}/gst/rvs \
    LIB_DIR=${libdir} \
"

do_install() {
    install -d ${D}${includedir}/gst/rvs
    install -m 0644 ${S}/gstcameradrivermeta.h ${D}${includedir}/gst/rvs/
    install -d ${D}${libdir}
    install -m 0755 ${S}/libgstcameradrivermeta.so ${D}${libdir}/libgstcameradrivermeta.so.0.0.0
    ln -sf libgstcameradrivermeta.so.0.0.0 ${D}${libdir}/libgstcameradrivermeta.so.0
    ln -sf libgstcameradrivermeta.so.0 ${D}${libdir}/libgstcameradrivermeta.so
    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/gstcameradrivermeta.pc ${D}${libdir}/pkgconfig/
}

INSANE_SKIP:${PN} += "dev-so"
