SUMMARY = "GStreamer Driver Meta"
DESCRIPTION = "Driver Meta for GStreamer used in RidgeRun's Video Stabilizer"
LICENSE = "CLOSED"


BRANCH ?= "master"
SRC_URI = "git://gitlab.ridgerun.com/open/gstreamer/ridgerun-video-stabilization/gstcameradrivermeta.git;protocol=https;branch=${BRANCH}"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"
inherit pkgconfig

do_install() {
    install -d ${D}${includedir}/gst/rvs
    install -m 0644 ${S}/gstcameradrivermeta.h ${D}${includedir}/gst/rvs/
    install -d ${D}${libdir}
    install -m 0755 ${S}/libgstcameradrivermeta.so ${D}${libdir}/libgstcameradrivermeta.so.0.0.0
    ln -sf libgstcameradrivermeta.so.0.0.0 ${D}${libdir}/libgstcameradrivermeta.so.0
    ln -sf libgstcameradrivermeta.so.0 ${D}${libdir}/libgstcameradrivermeta.so
    install -d ${D}${libdir}/pkgconfig
    cat > ${D}${libdir}/pkgconfig/gstcameradrivermeta.pc << 'EOF'
prefix=${prefix}
exec_prefix=${exec_prefix}
libdir=${libdir}
includedir=${includedir}

Name: gstcameradrivermeta
Description: RidgeRun GStreamer camera driver meta helper library
Version: ${PV}
Requires: gstreamer-1.0
Cflags: -I${includedir}/gst/rvs
Libs: -L${libdir} -lgstcameradrivermeta
EOF
}

INSANE_SKIP:${PN} += "dev-so"
