SUMMARY = "Xilinx Virtual Cable Daemon"
DESCRIPTION = "This is a daemon that listens to "xilinx_xvc" (xilinx virtual cable) traffic and operates JTAG over an FTDI in bitbang mode."
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=V4L2_PCIe"
LICENSE = "CLOSED"

DEPENDS = "libftdi"

# Set your settings here
SRCBRANCH ?= "master"
SRCREV = "d42b07f70cffd9e53f41c33b3960e1474cfbfc04"
SRC_URI = " git://github.com/RHSResearchLLC/xvcd.git;protocol=http;branch=${SRCBRANCH}"
SRC_URI[md5sum] = "74eb4336b08fff2578f388ace167de28"

PREFIX = "linux/src"

S = "${WORKDIR}/git/${PREFIX}"

SRC_URI += "file://fix-xvcd-recent-libftdi.patch"

do_configure () {
}

do_compile () {
        make CFLAGS="-Wall -Os -g -I${STAGING_DIR_TARGET}/usr/include/libftdi1/ -L${STAGING_DIR_TARGET}/usr/lib/ -l:libftdi1.so"
}