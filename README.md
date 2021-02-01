The Romi Chassis project for Team 5740 Java development learning.

## Assembling the Romi Kit  
Follow the instructions here for using the Romi kit: https://docs.wpilib.org/en/stable/docs/romi-robot/hardware.html

## Configuring the Pi
Following these instructions here:
https://docs.wpilib.org/en/stable/docs/romi-robot/imaging-romi.html

### Image Download
I downloaded the Raspberry Pi image from the WPILib Github Repo. (https://github.com/wpilibsuite/WPILibPi/releases/download/v2021.2.1/WPILibPi_image-v2021.2.1-Romi.zip). Save this file to a place you'll remember. 

### Imaging
After you have downloaded the ZIP file, you need to put it on the microSD card.  

Follow the instructions here: https://docs.wpilib.org/en/stable/docs/software/vision-processing/wpilibpi/installing-the-image-to-your-microsd-card.html

Use the Etcher tool to copy the zip file to the SD Card. That is, do not unzip the file.

Install the microSD card, and applied power to the Pi (via the Romi 32U4 board). 

The Pi will come up as WPILibPi-[random numbers]. It might take several minutes the first time you power on the Pi, possibly 5 or more.

Connected the laptop wifi to the Pi access point. The default WiFi access password is `WPILib2021!`. 

Once connected, use your Web Browser to go to this web page: `http://wpilibpi.local/`  

If you can view a web page, then, success! You've got the Pi imaged and running. 


## Update the Firmware.
If you've updated the image, or using the image for the first time, you should update the Romi control board firmware.  

Follow the instructions here: https://docs.wpilib.org/en/stable/docs/romi-robot/imaging-romi.html#u4-control-board
</br>


## Programming the Romi
Following the guide here: https://docs.wpilib.org/en/stable/docs/romi-robot/programming-romi.html


