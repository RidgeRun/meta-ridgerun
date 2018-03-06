SUMMARY = "Usrsctp"
DESCRIPTION = "Userland SCTP stack supporting FreeBSD, Linux, Mac OS X and Windows"
SECTION = "multimedia"
LICENSE = "BSD"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=ffcf846341f3856d79a483eafa18e2a5"

DEPENDS = ""

SRCBRANCH ?= "master"
SRCREV = "a9eb516d23d3eec6f2779d1b8965df01996a9836"
SRC_URI = " \
    git://git@github.com/sctplab/usrsctp.git;protocol=http;branch=${SRCBRANCH} \
    file://0001-usrsctp-yocto-compability.patch"

S = "${WORKDIR}/git"

PACKAGECONFIG_CONFARGS = ""

inherit autotools pkgconfig gettext

do_configure() {
        echo ${WORKDIR}
        ${S}/bootstrap
        oe_runconf
}
