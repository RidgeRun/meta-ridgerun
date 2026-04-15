SUMMARY = "GstQtOverlay"
DESCRIPTION = "GStreamer element used to overlay QML files over video streams"
SECTION = "multimedia"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../COPYING;md5=d28c53f3a5ec6efa235f27afaaa18be1"

DEPENDS = " \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    qtbase \
    qtbase-native \
    qtdeclarative \
    libffi \
    libinput \
    "

SRCBRANCH ?= "master"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git@gitlab.ridgerun.com/ridgerun/orders/${RR_CUSTOMER_GITLAB_ORDER_DIR}/gst-qt-overlay.git;protocol=ssh;branch=${SRCBRANCH}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig gettext rr_proprietary

FILES:${PN} += " \
    ${libdir}/gstreamer-1.0/libgstqtoverlay.so \
    "

EXTRA_OEMAKE += " 'CFLAGS=${CFLAGS} -DGL_GLEXT_PROTOTYPES  ' "
do_configure:prepend() {
  export PATH=$PATH:${RECIPE_SYSROOT_NATIVE}${bindir}/qt5/
}

do_compile:prepend() {
  export PATH=$PATH:${RECIPE_SYSROOT_NATIVE}${bindir}/qt5/
}

do_install:append() {
  rm -f ${D}${libdir}/gstreamer-1.0/libgstqtoverlay.a
}
