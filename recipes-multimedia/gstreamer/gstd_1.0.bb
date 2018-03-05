SUMMARY = "Gstreamer Daemon 1.0"
DESCRIPTION = "GStreamer framework for controlling audio and video streaming using TCP connection messages"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Gstd-1.0"
SECTION = "multimedia"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server json-glib libdaemon"

SRCBRANCH ?= "master"
SRCREV = "097a086a8606dcb368c7d38c7ec4fefc2497401b"
SRC_URI = "git://github.com/RidgeRun/gstd-1.x.git;protocol=https;branch=${SRCBRANCH} \
	   file://0001-gstd-yocto-compatibility.patch"

S = "${WORKDIR}/git"

PACKAGECONFIG_CONFARGS = " \
	--disable-gtk-doc \
"

inherit autotools pkgconfig gettext

do_configure() {
        ${S}/autogen.sh
        oe_runconf
}
