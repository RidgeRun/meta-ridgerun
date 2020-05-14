SUMMARY = "Gstreamer Daemon 1.0"
DESCRIPTION = "GStreamer framework for controlling audio and video streaming using TCP connection messages"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Gstd-1.0"
SECTION = "multimedia"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server json-glib libdaemon jansson"

SRCBRANCH ?= "master"
SRCREV = "d27418bedd2d8356f703ee3039ca8ac1f0762f67"
SRC_URI = "git://github.com/RidgeRun/gstd-1.x.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-gstd-yocto-compatibility.patch \
           "

S = "${WORKDIR}/git"

FILES_${PN} += "/run \
                /var/log \
                "

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--with-gstd-runstatedir=/run \
                --with-gstd-logstatedir=/var/log/ \
                "

do_configure() {
        ${S}/autogen.sh
        oe_runconf
}

do_install() {
        autotools_do_install
        install -d ${D}/run
        install -d ${D}/var/log/
        rm -rf ${D}/var/run
}
