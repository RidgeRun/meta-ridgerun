DESCRIPTION = "USB UVC Library 1.4.0"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base"

SRCBRANCH ?= "master"
SRC_URI = "git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/libguvc.git;protocol=ssh;branch=${SRCBRANCH};subpath=libguvc"


EXTRA_OECONF = "CFLAGS="-I${STAGING_KERNEL_DIR}/drivers/usb/gadget/function -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include" LDFLAGS=-lpthread"

INSANE_SKIP_${PN} = "ldflags"
INSANE_SKIP_${PN}-dev = "ldflags"
FILES_${PN} += "${libdir}/libguvc.so.0.0.0 "

inherit autotools pkgconfig gettext

S = "${WORKDIR}/libguvc"
B = "${WORKDIR}/libguvc"

do_configure() {
./autogen.sh --noconfigure
oe_runconf
}
