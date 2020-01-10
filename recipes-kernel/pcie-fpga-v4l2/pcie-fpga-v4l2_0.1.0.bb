SUMMARY = "PCI-E driver module for FPGA with V4L2 support"
DESCRIPTION = "Allows to send and retrieve data using V4L2 API from FPGA graphics accelerators connected through PCI-e using DMA transfers"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=V4L2_PCIe"
LICENSE = "Propietary"

LIC_FILES_CHKSUM = "file://copyrights.xml;md5=ade31ec14bee4ad39dd1a4c9f3a8f226"

inherit module

# Set your settings here
export PLATFORM = "xilinx"
SRCBRANCH ?= "master"
SRCREV = "a0090e5d9216ea2347c829dfef38d35242f86605"
SRC_URI = " git://git@gitlab.com/RidgeRun/orders/<Customer-Directory>/v4l2-fpga.git;protocol=ssh;branch=${SRCBRANCH}"

DRIVER_PREFIX = "src/kernel"

S = "${WORKDIR}/git/${DRIVER_PREFIX}"

FILES_${PN} += "${libdir}/modules/${KERNEL_VERSION}/kernel/drivers/media/pci/${PLATFORM}.ko"

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/media/pci/
	install -m 0644 ${WORKDIR}/git/${DRIVER_PREFIX}/${PLATFORM}/${PLATFORM}.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/media/pci/
}
