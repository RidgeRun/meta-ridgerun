SUMMARY = "Gst Color Transfer plugin"
DESCRIPTION = "Allows to transfer the color scheme of a reference image to a target."
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GStreamer_Color_Transfer"
SECTION = "multimedia"
LICENSE = "Proprietary"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

#######
#Note repo is private. SSH keys are needed to do_fetch
#Please add the SRCREV and CUSTOMER according to the information
#provided by Ridgerun with your order.
#######

SRCBRANCH ?= "master"
SRCREV_base = "b3cba38fcdd4c1001712e9b924520c5f1a65afbc"
SRCREV_common = "0acebceed78ce6054108c087b7c2ae34cf64314d"
CUSTOMER = ""

SRC_URI = " \
    git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/gst-color-transfer.git;protocol=ssh;branch=${SRCBRANCH};name=base; \
    git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/rr-build-utils.git;protocol=ssh;branch=${SRCBRANCH};name=common;destsuffix=git/common; \
    "

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
        --disable-tests \
"

FILES_${PN} += " ${libdir}/gstreamer-1.0/libgstcolortransfer.so "

FILES_${PN}-dev  += " ${libdir}/gstreamer-1.0/libgstcolortransfer.so "

inherit autotools pkgconfig gettext

