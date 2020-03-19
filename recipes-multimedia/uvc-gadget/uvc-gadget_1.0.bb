DESCRIPTION = "USB UVC Library (https://github.com/wlhe/uvc-gadget)"
SECTION = "examples"
LICENSE = "LGPLv2"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base "

SRC_URI = "file://uvc-gadget.tar.gz"

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/uvc-gadget"

inherit pkgconfig gettext

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/uvc-gadget/uvc-gadget ${D}${sbindir}/
}
