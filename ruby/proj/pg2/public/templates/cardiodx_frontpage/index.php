<?php
/**
 * @version                $Id: index.php 20874 2011-03-03 17:05:10Z dextercowley $
 * @package                Joomla.Site
 * @subpackage        tpl_beez2
 * @copyright        Copyright (C) 2005 - 2011 Open Source Matters, Inc. All rights reserved.
 * @license                GNU General Public License version 2 or later; see LICENSE.txt
 */

// No direct access.
defined('_JEXEC') or die;

JHTML::_('behavior.framework', true);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<?php echo $this->language; ?>" lang="<?php echo $this->language; ?>" dir="<?php echo $this->direction; ?>" >
        <head>
		<script type="javascript" src="images/flash/AC_RunActiveContent.js"></script>
		<script type="javascript" src="libraries/js/jquery-1.6.2.min.js"></script>
                <jdoc:include type="head" />
                <link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/system/css/system.css" type="text/css" />
                <link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/css/template.css" type="text/css" />
                <link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/css/joomla.css" type="text/css" />
                <link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/css/cardiodx.css" type="text/css" />

        </head>

        <body>

<a name="top"></a>

<div id="container">
    <div id="border">
        <div id="header">
                <div id="ticker">
<jdoc:include type="modules" name="ticker" style="" />
                </div>
            <div class="clear"></div>
                <div id="logo">
                        <jdoc:include type="modules" name="cardiodx_logo" style="" />

            </div>

            <div id="header-right">

	<div id="global">
	
		<div id="search-home">
			<jdoc:include type="modules" name="search" style="" />
		</div>

		<div id="global_nav">
			<jdoc:include type="modules" name="global" style="" />
		</div>

	</div>


            <div class="clear"></div>

            <div id="navigation-home">

<jdoc:include type="modules" name="topmenu" style="" />
            </div>

            </div> <!-- Close Header-right -->
            <div class="clear"></div>
        </div>

        <div id="main">
                <div id="theater">

                        <jdoc:include type="modules" name="theater" />

                </div>

            <div id="buckets">

                <div id="bkt1">
<jdoc:include type="modules" name="bkt1" style="" />
                </div>

		<div id="bkt2">
<jdoc:include type="modules" name="bkt2" style="" />
                </div>

                <div id="bkt3">
<jdoc:include type="modules" name="bkt3" style="" />

                </div>
            </div>
        </div>

<br style="clear:both;" />

    <div id="footer">
        <div id="copyright">
<jdoc:include type="modules" name="copyright" style="" />
<!-- <p>&copy; 2010 CardioDx, Inc. All rights reserved.</p> -->
</div>
<div id="footer_nav">
<jdoc:include type="modules" name="footernav" style="" />
<!-- <p><a id="l-17_s-971_t-24_u-0" target="_self" href="">HOME</a> &bull; <a href="news-and-resources/cardiodx-clinician-access-portal/" target="_self" id="l-675_s-971_t-24_u-0">CLINICIAN ACCESS PORTAL</a> &bull; <a id="l-20_s-971_t-24_u-0" target="_self" href="legal-and-privacy-policy/">LEGAL</a> &bull; <a href="corus-cad-intended-use/" target="_self" id="l-420_s-971_t-24_u-0">CORUS&trade; CAD INTENDED USE</a> &bull; <a id="l-22_s-971_t-24_u-0" target="_self" href="site-map/">SITE MAP</a> &bull; <a id="l-25_s-971_t-24_u-0" target="_self" href="company/contact-us/">CONTACT US</a></p>
-->
</div>
    <div class="clear">&nbsp;</div>
    </div>
</div>

<script type="text/javascript">
var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
</script>
<script type="text/javascript">
var pageTracker = _gat._getTracker("UA-1606987-26");
pageTracker._trackPageview();
</script>

<script type="text/javascript">
                                                /* <![CDATA[ */
                                                var hbac_google_links = new Array();
                                                for(var i=0; i<document.links.length; i++) {
                                                        var l = document.links[i];
                                                        var s = '';

if(hbac_regFileTypes.test(l.href)) {
                                                                
                                                                s = '/downloadTrack/'; // all file links
                                                        } else if(l.href.indexOf(document.location.hostname) == -1 && l.href.indexOf('http') != -1) {
                                                                
                                                                s = '/linkTrack/'; // all URL links
                                                        }
                                                        
                                                        if(s != '') {
                                                                s += l.href.replace(":"+l.port,"").replace(l.search,"").replace(l.hash,"").replace(new RegExp(/^http:\/\//i),"").replace(new RegExp(/^www\./i),"").replace(new RegExp(/\/$/),"").replace(new RegExp(/\//g),"-").replace(new RegExp(/\./g),"_");
                                                                hbac_google_links[l.href] = s;
                                                        }
                                                }
                                                hbac_linksCallBack += "hbac_google(this);";
                                                
                                                function hbac_google(obj) {
                                                        urchinTracker(hbac_google_links[obj.href]);
                                                        //alert("Google: "+hbac_google_links[obj.href]);
                                                }
                                                 /* ]]> */
                                        </script>

                                <script type="text/javascript">
                                        /* <![CDATA[ */
                                        var internalLinkRequest = null;
                                        function sendInternalLinkRequest(url,callbackMethod) {
                                                internalLinkRequest = XMLHttpObj();
                                                internalLinkRequest.onreadystatechange=callbackMethod;
                                                internalLinkRequest.open("POST",url,true);
                                                internalLinkRequest.send(url);
                                        }

                                        function internalLinkCallBack() {
                                                if(internalLinkRequest.readyState == 4) {
                                                        if(internalLinkRequest.status == 200) {
                                                                // No response action now, maybe add in the future.
                                                                //alert(internalLinkRequest.responseText);
                                                        }
                                                }
                                        }

var navID = 0;
                                        var citemID = 0;
                                        var metas = document.getElementsByTagName('meta');
                                        for(var i=0; i<metas.length; i++) {
                                                if(metas[i].name == "navID")
                                                        navID = metas[i].content;
                                                else if(metas[i].name == "citemID")
                                                        citemID = metas[i].content;
                                        }

                                        var hbac_internal_links = new Array();
                                        function hbac_internalLink(obj) {
                                                sendInternalLinkRequest("analyticsInternalLink.cfm"+hbac_internal_links[obj.href], internalLinkCallBack);
                                        }

                                        for(var i=0; i<document.links.length; i++) {
                                                var l = document.links[i];
                                                //if(l.href.lastIndexOf('/') == l.href.length-1) l.href = l.href.substring(0, l.href.length-1);

                                                if(hbac_regFileTypes.test(l.href) || (l.href.indexOf(document.location.hostname) == -1 && l.href.indexOf('http') != -1) || l.id.toLowerCase().indexOf('l') != -1)
                                                        l.onclick = function() {eval(hbac_linksCallBack);}

if(l.id.toLowerCase().indexOf('l') != -1) {
                                                        var HBLinkID = '';
                                                        var sourceID = '';
                                                        var sourceType = '';
                                                        var subType = '';

                                                        var l1 = l.id.split('_');
                                                        for(var j=0; j<l1.length; j++) {
                                                                var l2 = l1[j].split('-');
                                                                switch(l2[0].toLowerCase()) {
                                                                        case 'l':
                                                                                HBLinkID = l2[1];
                                                                                break;
                                                                        case 's':
                                                                                sourceID = l2[1];
                                                                                break;
                                                                        case 't':
                                                                                sourceType = l2[1];
                                                                                break;
                                                                        case 'u':
                                                                                subType = l2[1];
                                                                                break;
                                                                }
                                                        }
                                                        hbac_internal_links[l.href] = '?HBLinkID='+HBLinkID+'&sourceID='+sourceID+'&sourceType='+sourceType+'&subType='+subType+'&navID='+navID+'&citemID='+citemID;
                                                }
                                        }
                                        /* ]]> */
                                </script>


        </body>
</html>
