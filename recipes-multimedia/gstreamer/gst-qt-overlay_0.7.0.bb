SUMMARY = "GstQtOverlay"
DESCRIPTION = "GStreamer element used to overlay qml files over video streams"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=2282fc857e14ce7b17c1c9d810504ac5"

SRCBRANCH ?= "master"
SRCREV = "affb98136baa08a837f5f0735c654884796900f4"
SRC_URI = "git://git@gitlab.ridgerun.com/RidgeRun/orders/<Customer-Directory>/gst-qt-overlay.git;protocol=ssh;branch=${SRCBRANCH}"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad qtbase qtbase-native qtdeclarative libffi"

S = "${WORKDIR}/git"

FILES:${PN} += "${libdir}/gstreamer-1.0/libgstqtoverlay.so "

EXTRA_OEMAKE += " 'CFLAGS=${CFLAGS} -DGL_GLEXT_PROTOTYPES  ' "

inherit autotools pkgconfig gettext

do_configure:prepend() {
  export PATH=$PATH:${RECIPE_SYSROOT_NATIVE}/usr/bin/qt5/
}

do_compile:prepend() {
  export PATH=$PATH:${RECIPE_SYSROOT_NATIVE}/usr/bin/qt5/
}

do_install:append() {
  rm -f ${D}/usr/lib/gstreamer-1.0/libgstqtoverlay.a
}
