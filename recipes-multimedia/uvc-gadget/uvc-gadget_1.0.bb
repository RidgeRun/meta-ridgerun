DESCRIPTION = "USB UVC Library 1.3.0"
SECTION = "examples"
LICENSE = "CLOSED"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base "

SRC_URI = "file://uvc-gadget.tar.gz"

EXTRA_OECONF = "CFLAGS="-I${STAGING_KERNEL_DIR}/drivers/usb/gadget/function -I${STAGING_KERNEL_DIR}/include/uapi -I${STAGING_KERNEL_DIR}/include" LDFLAGS=-lpthread"

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/uvc-gadget"

inherit pkgconfig gettext

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/uvc-gadget/uvc-gadget ${D}${sbindir}/
}
