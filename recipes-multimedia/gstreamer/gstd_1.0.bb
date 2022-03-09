SUMMARY = "Gstreamer Daemon 1.0"
DESCRIPTION = "GStreamer framework for controlling audio and video streaming using TCP connection messages"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Gstd-1.0"
SECTION = "multimedia"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad gstreamer1.0-rtsp-server json-glib libdaemon jansson libsoup-2.4"

SRCBRANCH ?= "feature/fix-cpp-compilation-issues"
SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/RidgeRun/gstd-1.x.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-Remove-libgstc-python-directory-from-meson-build.patch \
           "

S = "${WORKDIR}/git"

FILES_${PN} += "/run \
                /var/log \
                ${libdir}/libgstd-1.0.so \
                ${libdir}/libgstc-1.0.so \
                "

EXTRA_OEMESON = "-Dwith-gstd-runstatedir=/run \
                -Dwith-gstd-logstatedir=/var/log/ \
                "

inherit meson pkgconfig gettext