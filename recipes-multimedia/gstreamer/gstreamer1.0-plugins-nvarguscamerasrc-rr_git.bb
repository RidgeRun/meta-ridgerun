SUMMARY = "RidgeRun patched NVIDIA nvarguscamerasrc GStreamer plugin"
DESCRIPTION = "RidgeRun custom nvarguscamerasrc plugin for Jetson/Argus camera capture"
SECTION = "multimedia"
LICENSE = "BSD-3-Clause & Proprietary"
LIC_FILES_CHKSUM = "file://README.txt;endline=25;md5=364434949752edc42711344c8401d55b \
                    file://nvbufsurface.h;endline=9;md5=15dccc547ee18664b1b6d1ece602942b"

SRC_URI = "git://gitlab.ridgerun.com/open/gstreamer/ridgerun-video-stabilization/gstnvarguscamerasrc.git;protocol=https;branch=jetpack-6.x \
           file://0001-nvarguscamerasrc-use-JetPack-6-Argus-error-event-typ.patch \
           "

PV = "1.0+git"
SRCREV = "62a7dab1e795991cb3d99da99e75549579bbf569"

S = "${WORKDIR}/git"
B = "${S}"

inherit pkgconfig

COMPATIBLE_MACHINE = "(jetson-.*)"

DEPENDS += "  \
glib-2.0  \
gstreamer1.0  \
gstreamer1.0-plugins-base  \
tegra-libraries-camera  \
tegra-libraries-multimedia-ds  \
tegra-mmapi  \
virtual/egl  \
gstcameradrivermeta \
"

RDEPENDS:${PN} += " gstcameradrivermeta tegra-argus-daemon"

# This package intentionally replaces the stock meta-tegra nvarguscamerasrc.

RPROVIDES:${PN} += "gstreamer1.0-plugins-nvarguscamerasrc"
RCONFLICTS:${PN} += "gstreamer1.0-plugins-nvarguscamerasrc"
RREPLACES:${PN} += "gstreamer1.0-plugins-nvarguscamerasrc"

do_compile() {
    GST_CFLAGS="$(pkg-config --cflags \
        gstreamer-1.0 \
        gstreamer-base-1.0 \
        gstreamer-video-1.0 \
        gstreamer-allocators-1.0 \
        glib-2.0)"

    GST_LIBS="$(pkg-config --libs \
        gstreamer-1.0 \
        gstreamer-base-1.0 \
        gstreamer-video-1.0 \
        gstreamer-allocators-1.0 \
        glib-2.0)"

    oe_runmake clean || true

    oe_runmake \
        CC="${CC}" \
        CXX="${CXX}" \
        CFLAGS="${CFLAGS} ${CPPFLAGS} -fPIC ${GST_CFLAGS} \
            -I${RECIPE_SYSROOT}${includedir}/Argus/utils \
            -I${RECIPE_SYSROOT}/usr/src/jetson_multimedia_api/include \
            -I${RECIPE_SYSROOT}/usr/src/jetson_multimedia_api/argus/samples/utils" \
        LIBS="-lnvbufsurface -lnvbufsurftransform -lnvdsbufferpool \
            -lnvargus_socketclient -lpthread -lgstcameradrivermeta \
            ${GST_LIBS}" \
        LIB_INSTALL_DIR="${RECIPE_SYSROOT}${libdir}/tegra" \
        LDFLAGS="${LDFLAGS} \
            -L${RECIPE_SYSROOT}${libdir} \
            -L${RECIPE_SYSROOT}${libdir}/tegra \
            -Wl,-rpath-link,${RECIPE_SYSROOT}${libdir} \
            -Wl,-rpath-link,${RECIPE_SYSROOT}${libdir}/tegra \
            -Wl,--no-undefined"
}

do_install() {
    install -d ${D}${libdir}/gstreamer-1.0
    install -m 0755 ${S}/libgstnvarguscamerasrc.so \
        ${D}${libdir}/gstreamer-1.0/libgstnvarguscamerasrc.so
}

FILES:${PN} += "  \
${libdir}/gstreamer-1.0/libgstnvarguscamerasrc.so  \
"

