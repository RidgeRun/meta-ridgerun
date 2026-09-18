SUMMARY = "RidgeRun GStreamer camera driver metadata library"
SECTION = "multimedia"
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

BRANCH ?= "master"
SRC_URI = "git://gitlab.ridgerun.com/open/gstreamer/ridgerun-video-stabilization/gstcameradrivermeta.git;protocol=https;branch=${BRANCH}"

PV = "1.0+git"
SRCREV = "fe3052d7d34723b8e25149ea3bfe476d0211763b"

S = "${WORKDIR}/git"
B = "${S}"

COMPATIBLE_MACHINE = ".*"

inherit pkgconfig

DEPENDS += " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_compile() {
    GST_CFLAGS="$(pkg-config --cflags gstreamer-1.0)"
    GST_LIBS="$(pkg-config --libs gstreamer-1.0)"

    oe_runmake \
        CC="${CC}" \
        CFLAGS="${CFLAGS} ${CPPFLAGS} -fPIC ${GST_CFLAGS}" \
        LDFLAGS="${LDFLAGS} -shared ${GST_LIBS}" \
        PREFIX="${prefix}" \
        INC_DIR="${includedir}/gst/rvs" \
        LIB_DIR="${libdir}" \
        PKG_DIR="${libdir}/pkgconfig"
}

do_install() {
    install -d ${D}${includedir}/gst/rvs
    install -m 0644 ${S}/gstcameradrivermeta.h ${D}${includedir}/gst/rvs/

    install -d ${D}${libdir}
    install -m 0755 ${S}/libgstcameradrivermeta.so ${D}${libdir}/

    install -d ${D}${libdir}/pkgconfig
    install -m 0644 ${S}/gstcameradrivermeta.pc ${D}${libdir}/pkgconfig/

    sed -i \
        -e 's|/usr/local/include/gst/rvs|${includedir}/gst/rvs|g' \
        -e 's|/usr/local/lib|${libdir}|g' \
        -e 's|${D}||g' \
        ${D}${libdir}/pkgconfig/gstcameradrivermeta.pc
}

FILES:${PN} += " \
    ${libdir}/libgstcameradrivermeta.so \
"

FILES:${PN}-dev += " \
    ${includedir}/gst/rvs \
    ${libdir}/pkgconfig/gstcameradrivermeta.pc \
"
