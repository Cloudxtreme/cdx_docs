<?php
/**
 * @version                $Id: component.php 20196 2011-01-09 02:40:25Z ian $
 * @package                Joomla.Site
 * @subpackage        tpl_beez2
 * @copyright        Copyright (C) 2005 - 2011 Open Source Matters, Inc. All rights reserved.
 * @license                GNU General Public License version 2 or later; see LICENSE.txt
 */

// No direct access.
defined('_JEXEC') or die;

$color = $this->params->get('templatecolor');
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="<?php echo $this->language; ?>" lang="<?php echo $this->language; ?>" dir="<?php echo $this->direction; ?>">
<head>
	<jdoc:include type="head" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/system/css/system.css" type="text/css" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/template.css" type="text/css" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/position.css" type="text/css" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/layout.css" type="text/css" media="screen,projection" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/print.css" type="text/css" media="Print" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/<?php echo $color; ?>.css" type="text/css" />
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/cardiodx.css" type="text/css" />
<?php
	$files = JHtml::_('stylesheet','templates/beez_20/css/general.css',null,false,true);
	if ($files):
		if (!is_array($files)):
			$files = array($files);
		endif;
		foreach($files as $file):
?>
			<link rel="stylesheet" href="<?php echo $file;?>" type="text/css" />
<?php
		endforeach;
	endif;
?>

<?php if($this->direction == 'rtl') : ?>
	<link rel="stylesheet" href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/template_rtl.css" type="text/css" />
<?php endif; ?>
<!--[if lte IE 6]>
	<link href="<?php echo $this->baseurl ?>/templates/<?php echo $template; ?>/css/ieonly.css" rel="stylesheet" type="text/css" />
<![endif]-->
</head>
<body class="contentpane">
	<div id="all">
		<div id="main">
				 <jdoc:include type="modules" name="printcardiodx" />
        		<div id="printbuttons">
                		<jdoc:include type="modules" name="printbuttons" />
        		</div>
        		<div id="breadcrumbs">
                		<jdoc:include type="modules" name="breadcrumbs" />
        		</div>
        		<div id="printcontent">
        		<div id="printheadbanner">
                		<jdoc:include type="modules" name="headbanner" />
        		</div>
				<jdoc:include type="message" />
				<jdoc:include type="component" />
			</div>
		        <div id="printfooter">
                		<jdoc:include type="modules" name="printfooter" />
       			 </div>

		</div>
	</div>
</body>
</html>
