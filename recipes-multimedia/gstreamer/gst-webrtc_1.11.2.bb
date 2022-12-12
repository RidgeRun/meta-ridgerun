SUMMARY = "GstWebRTC"
DESCRIPTION = "GStreamer plug-in that turns pipelines into WebRTC compliant endpoints, which allows audio and/or video streaming using the WebRTC protocol"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GstWebRTC"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad json-glib libsoup-2.4 libnice autoconf libtool glib-2.0 openssl readline libsrtp usrsctp openwebrtc-gst-plugins"

SRCBRANCH ?= "master"

SRCREV_FORMAT = "base_common"
SRCREV_base = "e92de7a5c14428fdf7d6be31e31c21fca89c345a"
SRCREV_common = "b64f03f6090245624608beb5d2fff335e23a01c0"

SRC_URI = " \ 
    git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-webrtc.git;protocol=ssh;branch=${SRCBRANCH};name=base \
    git://anongit.freedesktop.org/git/gstreamer/common.git;protocol=https;destsuffix=git/common;name=common; \
    "

S = "${WORKDIR}/git"

PACKAGECONFIG_CONFARGS = " \
	--disable-gtk-doc \
"
FILES_${PN} += "\
	${libdir}/gstreamer-1.0/libgstrrwebrtc.so \
	${libdir}/gstreamer-1.0/libgstrrwebrtc.la \
"

inherit autotools pkgconfig gettext
