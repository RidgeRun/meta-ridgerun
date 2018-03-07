SUMMARY = "OpenWebRTC specific GStreamer plugins"
DESCRIPTION = "Plugins in this repository: ercolorspace, androidvideo, videorepair, sctp"
SECTION = "multimedia"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://LICENSE;md5=34e05c5cfe87e7aec2dc32bd24ebdb33"

DEPENDS = "gstreamer1.0 glib-2.0 gstreamer1.0-plugins-base usrsctp"

SRCBRANCH ?= "master"

SRCREV = "91d339b455c69c16dfd51a3a2f37c1127d4880cc"

SRC_URI = " \
    git://git@github.com/EricssonResearch/openwebrtc-gst-plugins.git;protocol=http;branch=${SRCBRANCH} \
    file://0001-openwebrtc-gst-plugins-yocto-compability.patch \
    "

S = "${WORKDIR}/git"

FILES_${PN} += "\
	${libdir}/gstreamer-1.0/libgstvideorepair.la  \
	${libdir}/gstreamer-1.0/libgstsctp.so \
	${libdir}/gstreamer-1.0/libgstscream.so \
	${libdir}/gstreamer-1.0/libgstsctp.la \
	${libdir}/gstreamer-1.0/libgstscream.la \
	${libdir}/gstreamer-1.0/libgstvideorepair.so \
"

inherit autotools pkgconfig gettext

do_configure() {
	${S}/autogen.sh
        oe_runconf
}
