SUMMARY = "Gstreamer Daemon 0.13.0"
DESCRIPTION = "GStreamer framework for controlling audio and video streaming using TCP connection messages"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Gstd-1.0"
SECTION = "multimedia"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server json-glib libdaemon jansson libsoup-2.4"

SRCBRANCH ?= "master"
SRCREV = "fa523d54628b04fe3242ba126ab069e0b35a618b"
SRC_URI += "git://github.com/RidgeRun/gstd-1.x.git;protocol=https;branch=${SRCBRANCH} \
            file://0001-srcdir-in-autogen.sh.patch \
            file://0002-Remove-compile-options-LIBSOUP_LIBS-in-gstd.patch \
            file://0003-Source-dir-for-link-of-gst-client.patch \
            file://0004-Remove-libgstc.patch \
            "

S = "${WORKDIR}/git"

FILES_${PN} += "/run \
                /var/log \
                "
FILES_${PN} += "${libdir}/systemd/*"

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
