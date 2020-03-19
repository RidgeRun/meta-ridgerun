DESCRIPTION = "USB UVC Library (https://github.com/wlhe/uvc-gadget)"
SECTION = "examples"
LICENSE = "LGPLv2"

SRC_URI = "file://uvc-gadget.tar.gz"

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/uvc-gadget"

inherit pkgconfig gettext

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/uvc-gadget/uvc-gadget ${D}${sbindir}/
}
