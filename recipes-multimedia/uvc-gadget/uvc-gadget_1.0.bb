DESCRIPTION = "USB UVC Library (https://github.com/wlhe/uvc-gadget)"
SECTION = "examples"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "file://uvc-gadget.tar.gz"

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/uvc-gadget"

inherit pkgconfig gettext

do_install () {
    install -d ${D}${sbindir}
    install -m 0755 ${WORKDIR}/uvc-gadget/uvc-gadget ${D}${sbindir}/
}
