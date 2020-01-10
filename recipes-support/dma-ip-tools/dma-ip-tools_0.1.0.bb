SUMMARY = " Xilinx PCIe DMA drivers"
DESCRIPTION = "The Xilinx PCI Express Multi Queue DMA (QDMA) IP provides high-performance direct memory access (DMA) via PCI Express."
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=V4L2_PCIe"
LICENSE = "CLOSED"

#DEPENDS = "libftdi"

# Set your settings here
SRCBRANCH ?= "master"
SRCREV = "ac1c9e2e7403ba2c94352766bef1328e31aa1576"
SRC_URI = " git://github.com/Xilinx/dma_ip_drivers.git;protocol=http;branch=${SRCBRANCH}"
SRC_URI[md5sum] = "74eb4336b08fff2578f388ace167de28"

PREFIX = "XDMA/linux-kernel/tools"

S = "${WORKDIR}/git/${PREFIX}"

do_configure () {
}

do_compile () {
	make
}