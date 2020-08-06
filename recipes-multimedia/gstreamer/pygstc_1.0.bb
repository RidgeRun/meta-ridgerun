SUMMARY = "Python client package to interact with GStreamer Daemon 1.0"
DESCRIPTION = "Python client package for controlling audio and video streaming using TCP connection messages"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=Gstd-1.0"
SECTION = "multimedia"
LICENSE = "GPLv2+"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "python3 python3-pip gstd"

SRCBRANCH ?= "master"
SRCREV = "d27418bedd2d8356f703ee3039ca8ac1f0762f67"
SRC_URI = "git://github.com/RidgeRun/gstd-1.x.git;protocol=https;branch=${SRCBRANCH} \
           file://0001-Link-license-file.patch \
           "

S = "${WORKDIR}/git/libgstc"

SRCNAME = "pygstc"

inherit setuptools3

