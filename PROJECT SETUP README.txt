Because of the level of development that creating an android app requires, there are a few things that need to be set up before your system is capable of simulating an android system.

I wrote this to remember what I did, and to help you get your system set up with less trouble then me.

First you need the studio:
http://developer.android.com/sdk/index.html

Then you need to turn on Virtualization on your CPU, this is native to Intel, so you need to have an intel processor (i3,i5,i7, ect).  To turn this on, you need to go into your BIOS and actually activate Virtualization or VT-x.

Once this is on, you need to get HAXM:
https://software.intel.com/en-us/android/articles/intel-hardware-accelerated-execution-manager

