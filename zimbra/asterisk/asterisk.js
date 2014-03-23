function Com_Zimbra_Asterisk() { }
Com_Zimbra_Asterisk.prototype = new ZmZimletBase();
Com_Zimbra_Asterisk.prototype.constructor = Com_Zimbra_Asterisk;
Com_Zimbra_Asterisk.prototype.menuItemSelected = function(itemId) { };

Com_Zimbra_Asterisk.prototype.fixNumber = function(phoneNumber) {
	var numStr = String(phoneNumber);
	numStr = numStr.replace(/[\n\r]/g,'');
	numStr = numStr.replace(/\D/g,'');
	if (numStr.length == 10) {numStr = "1"+numStr;}
	return numStr;
};

Com_Zimbra_Asterisk.prototype.doDrop = function(myobj) { this.setupCall(myobj); };
Com_Zimbra_Asterisk.prototype.doubleClicked = function() { this.singleClicked(); };
Com_Zimbra_Asterisk.prototype.singleClicked = function() { this.setupCall(); };

Com_Zimbra_Asterisk.prototype.clicked = function(myElement, callee) {
	var reqHeader = {"Content-Type":"application/x-www-form-urlencoded"};
	var url = this.getResource('asterisk.jsp');
	var to = AjxStringUtil.urlEncode(this.fixNumber(callee));
	var reqParam = 'to=' + to + '&login=' + this.getUsername();
//	this.displayStatusMessage('Calling: ' + callee); 
	AjxRpc.invoke(reqParam, url, reqHeader, new AjxCallback(this, this._resultCallback));
};

Com_Zimbra_Asterisk.prototype.setupCall = function(myobj) {

	var editorProps = [];

	if (myobj != null && typeof(myobj) == 'object') {

		if (myobj.TYPE == "ZmContact") {

				editorProps[0] = 
					{ 
						label			: "Call",
						name			: "number1",
						type			: "enum",
						width			: 100,
						value			: "",
						item			: [ ]
					};

				i = 0;
				for (var p in myobj) {
					
					if (p.slice(-5) == "Phone" && myobj[p] != null) {
						var lb = p.slice(0,-5);
						editorProps[0].item[i] = {};
						editorProps[0].item[i].label = lb+": "+myobj[p];
						editorProps[0].item[i].value = myobj[p];
						i++;
					}
				}
				if (myobj.mobilePhone != null) {
					editorProps[0].value = myobj.mobilePhone.toString();
				}
		} 
		
	} else {
		editorProps[0].value = "";
	}

	if (this._dlg_propertyEditor) {
		this._dlg_propertyEditor.dispose();
	}
	this._dlg_propertyEditor = null;

	var view = new DwtComposite(this.getShell());
	this._propertyEditor = new DwtPropertyEditor(view, true);
	var pe = this._propertyEditor;
	pe.initProperties(editorProps);
	var dialog_args = {
		title : "Place Call",
		view  : view
	};
	this._dlg_propertyEditor = this._createDialog(dialog_args);
	var dlg = this._dlg_propertyEditor;
	pe.setFixedLabelWidth();
	pe.setFixedFieldWidth();
	dlg.setButtonListener(DwtDialog.OK_BUTTON,
						new AjxListener(this, function() {
							if (!pe.validateData()) {
								return;
							}
							this._placeCall();
						}));

	this._dlg_propertyEditor.popup();
};


Com_Zimbra_Asterisk.prototype._placeCall = function () {
	var properties = this._propertyEditor.getProperties();

	this._dlg_propertyEditor.popdown();
	this._dlg_propertyEditor.dispose();
	this._dlg_propertyEditor = null;

	var url = this.getResource('asterisk.jsp');
	var reqHeader = {"Content-Type":"application/x-www-form-urlencoded"};

	var to = "";
	var finalto = "";

	for (var callee in properties) {
		to = properties[callee];
		finalto = AjxStringUtil.urlEncode(this.fixNumber(to));
	}
	login=this.getUsername();
	var reqParam = 'to=' + finalto + '&login=' + login;
	this.displayStatusMessage('Calling: ' + to); 
	//alert('setupCalls: ' + reqParam);
	DBG.println(AjxDebug.DBG2, reqParam);
	AjxRpc.invoke(reqParam, url, reqHeader, new AjxCallback(this, this._resultCallback));
};

Com_Zimbra_Asterisk.prototype._resultCallback = function(result) {
	var r = result.text;
	DBG.println(AjxDebug.DBG2, "result:" + r);
	this.displayStatusMessage(r); 
	//alert(r);
};

