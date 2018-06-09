# Desktop GUI Wallet for [Asofe](https://asofe.org/)[®](#disclaimer)

## Graphical user interface wrapper for the [Asofe](https://asofe.org/)[®](#disclaimer) command line tools

This program provides a Graphical User Interface (GUI) for the Asofe client tools that acts as a wrapper and 
presents the information in a user-friendly manner.

## Building, installing and running the Wallet GUI

Before installing the Desktop GUI Wallet you need to have Asofe up and running. The following [guide](https://github.com/zcash/zcash/wiki/1.0-User-Guide) 
explains how to set up [Asofe](https://asofe.org/). There is also a user-friendly [instructional video](https://www.youtube.com/watch?v=ZoRFLkZG0zg&feature=youtu.be)
on the same topic.

**For security reasons it is recommended to always build the GUI wallet program from GitHub**
**[source](https://github.com/TheLightSide/asofe-swing-wallet-ui/archive/master.zip).**
The details of how to build it are described below (easy to follow). 
Project [snapshot tags](https://github.com/TheLightSide/asofe-swing-wallet-ui/tags) named x.xx-SNAPSHOT have been
signed with the following [public key](https://github.com/TheLightSide/asofe-swing-wallet-ui/blob/master/docs/IV_Github_GPG_public_key.txt).
Users who are less experienced with working on a command line, may instead use this 
quite-user-friendly [installation guide](https://www.cryptocompare.com/wallets/guides/how-to-install-the-zcash-gui-wallet) 
and [usage guide](https://www.cryptocompare.com/wallets/guides/how-to-use-the-zcash-gui-wallet).
The following video also explains how to [set up the GUI wallet](https://www.youtube.com/watch?v=IDifG4h1bgE). 


1. Operating system and tools

   As of May 2018 (Asofe v1.0.15) this program is mostly tested on Linux and Mac OS X
   (same limitation as [Asofe](https://asofe.org/)) with experimental support for Windows.
   The Linux tools you need to build and run the Wallet GUI are Git, Java (JDK7 or later) and
   Ant. If using Ubuntu Linux, they may be installed via command: 
   ```
   user@ubuntu:~/build-dir$ sudo apt-get install git default-jdk ant
   ``` 
   For RedHat/CentOS/Fedora-type Linux systems the command is (like):
   ```
   user@centos:~/build-dir$ sudo yum install java-1.8.0-openjdk git ant 
   ```
   The name of the JDK package (`java-1.8.0-openjdk`) may vary depending on the Linux system, so you need to
   check it, if name `java-1.8.0-openjdk` is not accepted.
   If you have some other Linux distribution, please check your relevant documentation on installing Git, 
   JDK and Ant. The commands `git`, `java`, `javac` and `ant` need to be startable from command line 
   before proceeding with build.

2. Building from source code

   As a start you need to clone the zcash-swing-wallet-ui Git repository:
   ```
   user@ubuntu:~/build-dir$ git clone https://github.com/TheLightSide/asofe-swing-wallet-ui.git
   ```
   Change the current directory:
   ```
   user@ubuntu:~/build-dir$ cd asofe-swing-wallet-ui/
   ```
   Issue the build command:
   ```
   user@ubuntu:~/build-dir/asofe-swing-wallet-ui$ ant -buildfile ./src/build/build.xml
   ```
   This takes a few seconds and when it finishes, it builds a JAR file `./build/jars/ZCashSwingWalletUI.jar`. 
   You need to make this file executable:
   ```
   user@ubuntu:~/build-dir/asofe-swing-wallet-ui$ chmod u+x ./build/jars/ZCashSwingWalletUI.jar
   ```
   At this point the build process is finished the built GUI wallet program is the JAR 
   file `./build/jars/ZCashSwingWalletUI.jar`

3. Installing the built Asofe GUI wallet

  3.1. If you have built Asofe from source code:

   Assuming you have already built from source code [Asofe](https://asofe.org/) in directory `/home/user/asofe/src` (for 
   example - this is the typical build dir. for Asofe v1.0.15) which contains the command line tools `asofe-cli` 
   and `asofed` you need to take the created file `./build/jars/ZCashSwingWalletUI.jar` and copy it 
   to directory `/home/user/asofe/src` (the same dir. that contains `asofe-cli` and `asofed`). Example copy command:
   ```
   user@ubuntu:~/build-dir/asofe-swing-wallet-ui$ cp ./build/jars/ZCashSwingWalletUI.jar /home/user/asofe/src    
   ```

  3.2. If you have downloaded the [Asofe Binary distribution](https://www.asofe.org/miners.html):

   Assuming you have already downloaded the file `asofe-1.0.x-linux64.tar.gz` which contains the command 
   line tools `asofe-cli` and `asofed` and after decompressing it they are in a directory like 
   `/home/user/asofe-1.0.x/bin/` take the created file `./build/jars/ZCashSwingWalletUI.jar` and copy it 
   to directory `/home/user/asofe-1.0.x/bin/` (the same dir. that contains `asofe-cli` and `asofed`). 
   Example copy command:
   ```
   user@ubuntu:~/build-dir/asofed-swing-wallet-ui$ cp ./build/jars/ZCashSwingWalletUI.jar /home/user/asofe-1.0.8/bin/    
   ```
   
  3.3. If you have installed the Asofe [binary packages](https://github.com/zcash/zcash/wiki/Debian-binary-packages)

   The command line tools `zcash-cli` and `zcashd` are placed by the package installer in:
   ```
   /usr/bin/asofe-cli
   /usr/bin/asofed
   ```
   The Asofe GUI wallet knows how to find them there. You may place the file  `./build/jars/ZCashSwingWalletUI.jar`
   anywhere in your `/home` directory that you find convenient and start it from there.

4. Running the installed Asofe GUI wallet

   Before running the GUI you need to start asofed (e.g. `asofed --daemon`). The wallet GUI is a Java program packaged 
   as an executable JAR file. It may be run from command line or started from another GUI tool (e.g. file manager). 
   Assuming you have already installed [Asofe](https://asofe.org/) and the GUI Wallet `ZCashSwingWalletUI.jar` in 
   directory `/home/user/asofe/src` one way to run it from command line is:
   ```
   user@ubuntu:~/build-dir/asofe-swing-wallet-ui$ java -jar /home/user/asofe/src/ZCashSwingWalletUI.jar
   ```
   If you are using Ubuntu (or similar ;) Linux you may instead just use the file manager and 
   right-click on the `ZCashSwingWalletUI.jar` file and choose the option "Open with OpenJDK 8 Runtime". 
   This will start the Asofe GUI wallet.

### License
This program is distributed under an [MIT License](https://github.com/TheLightSide/asofe-swing-wallet-ui/raw/master/LICENSE).

### Disclaimer
This program is not officially endorsed by or associated with the Asofe project and the Asofe company.
[Zerocoin Electric Coin Company](https://trademarks.justia.com/owners/zerocoin-electric-coin-company-3232749/).

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

### Known issues and limitations

1. Issue: Wallet versions 0.58 and below, when running on systems with (typically non-western) locales that
redefine the decimal point in the OS locale settings, have problems with updating the GUI wallet state. 
A workaround is to change the [locale settings](https://windows.lbl.gov/software/optics/5-1-2/Optics4.jpg) to have dot as decimal separator.
1. Limitation: Wallet encryption has been temporarily disabled in ZCash due to stability problems. A corresponding issue 
[#1552](https://github.com/zcash/zcash/issues/1552) has been opened by the ZCash developers. Correspondingly
wallet encryption has been temporarily disabled in the ZCash Desktop GUI Wallet.
1. Issue: the GUI wallet does not work correctly if zcashd is started with a custom data directory, like:
`asofed -datadir=/home/data/whatever` This will be fixed in later versions.
1. Issue: GUI data tables (transactions/addresses etc.) allow copying of data via double click but also allow editing. 
The latter needs to be disabled. 
1. Limitation: The list of transactions does not show all outgoing ones (specifically outgoing Z address 
transactions). A corresponding issue [#1438](https://github.com/zcash/zcash/issues/1438) has been opened 
for the ZCash developers. 
1. Limitation: The CPU percentage shown to be taken by zcashd on Linux is the average for the entire lifetime 
of the process. This is not very useful. This will be improved in future versions.
