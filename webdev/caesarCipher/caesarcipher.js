function caesarEnc1K() {
	var alpha="abcdefghijklmnopqrstuvwxyz";
	var origMsg = document.getElementById("message").value;
	var lowerMsg = origMsg.toLowerCase();
	var encrMsg = "";
	var currChar;
	var idxChar;
	var newChar;
	var key1 = document.getElementById("keyone").value;
	var shiftedAlphabet = shiftAlpha(key1);
	for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		currChar = lowerMsg.charAt(ctr);
		idxChar = alpha.indexOf(currChar);
		if(idxChar==-1){
			encrMsg += currChar;
		}
		if (idxChar!=-1){
			newChar = shiftedAlphabet.charAt(idxChar);
			encrMsg += newChar;
		}
	}
	oneKeyDisplay(shiftedAlphabet,origMsg,encrMsg);
	}
	
function caesarEnc2K() {
	var alpha="abcdefghijklmnopqrstuvwxyz";
	var origMsg = document.getElementById("message").value;
	var lowerMsg = origMsg.toLowerCase();
	var encrMsg = "";
	var currChar;
	var idxChar;
	var newChar;
	var key1 = document.getElementById("keyone").value;
	var key2 = document.getElementById("keytwo").value;
	var shiftedAlphabet1 = shiftAlpha(key1);
	var shiftedAlphabet2 = shiftAlpha(key2);
	for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		currChar = lowerMsg.charAt(ctr);
		idxChar = alpha.indexOf(currChar);
		if(idxChar==-1){
			encrMsg += currChar;
		}
		if (idxChar!=-1){
			if(ctr % 2 == 0){
				newChar = shiftedAlphabet1.charAt(idxChar);
				encrMsg += newChar;
			}
			if(ctr % 2 == 1){
				newChar = shiftedAlphabet2.charAt(idxChar);
				encrMsg += newChar;
			}
		}
	}
	twoKeyDisplay(shiftedAlphabet1,shiftedAlphabet2,origMsg,encrMsg);
	}

function shiftAlpha(key) {
		var alpha="abcdefghijklmnopqrstuvwxyz";
		var validNums = /[0-9.]/;
		var shiftedAlphabetFirstHalf;
		var shiftedAlphabetSecondHalf;
		var shiftedAlphabet;
        if(!isNaN(key)){
			shiftedAlphabetFirstHalf = alpha.substr(key);
			shiftedAlphabetSecondHalf = alpha.substr(0,key);
			shiftedAlphabet = shiftedAlphabetFirstHalf.concat(shiftedAlphabetSecondHalf);
		}
		return shiftedAlphabet;
	}
	
function oneKeyDisplay(shifted,orig,encr1k){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong><br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet:</strong><br>"+shifted+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Encrypted Message:</strong><br>"+encr1k+"</p>"
	}
	
function twoKeyDisplay(shifted1,shifted2,orig,encr2k){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong> <br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet</strong><br>"+"Shifted Alphabet 1: "+shifted1+"<br>Shifted Alphabet 2: "+shifted2+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Encrypted Message:</strong><br>"+encr2k+"</p>"
	}

function oneKeyDecrDisplayK(shifted,orig,encr1k,keyUsed){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong><br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet:</strong><br>"+shifted+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Decrypted Message:</strong><br>"+encr1k+"</p>"
	}
	
function twoKeyDecrDisplayK(shifted1,shifted2,orig,encr2k,key1Used,key2Used){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong> <br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet</strong><br>"+"Shifted Alphabet 1: "+shifted1+"<br>Shifted Alphabet 2: "+shifted2+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Decrypted Message:</strong><br>"+encr2k+"</p>"
	}

function oneKeyDecrDisplayUk(shifted,orig,encr1k,keyUsed){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong><br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet:</strong><br>"+shifted+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Decrypted Message:</strong><br>"+encr1k+"</p><p><strong>Key Used:</strong><br>"+keyUsed+"</p>"
	}
	
function twoKeyDecrDisplayUk(shifted1,shifted2,orig,encr2k,key1Used,key2Used){
		document.getElementById("results").innerHTML = "<p><strong>Normal Alphabet:</strong> <br>abcedfghijklmnopqrstuvwxyz</p><p><strong>Shifted Alphabet</strong><br>"+"Shifted Alphabet 1: "+shifted1+"<br>Shifted Alphabet 2: "+shifted2+"</p><p><strong>Original Message:</strong><br>"+orig+"</p><p><strong>Decrypted Message:</strong><br>"+encr2k+"</p><p><strong>Keys Used:</strong><br>"+key1Used+" and "+key2Used+"</p>"
	}
	
function reloadPage(){
		history.back();
	}

function decryptKnown1Key(){
    var alpha="abcdefghijklmnopqrstuvwxyz";
	var origMsg = document.getElementById("message").value;
	var lowerMsg = origMsg.toLowerCase();
	var decrMsg = "";
	var currChar;
	var idxChar;
	var newChar;
	var offset = 26;
	var key1 = document.getElementById("keyone").value;
	key1 = offset - key1;
	var shiftedAlphabet = shiftAlpha(key1);
	for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		currChar = lowerMsg.charAt(ctr);
		idxChar = alpha.indexOf(currChar);
		if(idxChar==-1){
			decrMsg += currChar;
		}
		if (idxChar!=-1){
			newChar = shiftedAlphabet.charAt(idxChar);
			decrMsg += newChar;
		}
	}
	oneKeyDecrDisplayK(shiftedAlphabet,origMsg,decrMsg);
}

function decryptKnown2Key(){
    var alpha="abcdefghijklmnopqrstuvwxyz";
	var origMsg = document.getElementById("message").value;
	var lowerMsg = origMsg.toLowerCase();
	var decrMsg = "";
	var currChar;
	var idxChar;
	var newChar;
	var offset = 26;
	var key1 = offset - document.getElementById("keyone").value;
	var key2 = document.getElementById("keytwo").value;
	var shiftedAlphabet1 = shiftAlpha(key1);
	var shiftedAlphabet2 = shiftAlpha(26 - key2);
	for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		currChar = lowerMsg.charAt(ctr);
		idxChar = alpha.indexOf(currChar);
		if(idxChar==-1){
			decrMsg += currChar;
		}
		if (idxChar!=-1){
			if(ctr % 2 == 0){
				newChar = shiftedAlphabet1.charAt(idxChar);
				decrMsg += newChar;
			}
			if(ctr % 2 == 1){
				newChar = shiftedAlphabet2.charAt(idxChar);
				decrMsg += newChar;
			}
		}
	}
	twoKeyDecrDisplayK(shiftedAlphabet1,shiftedAlphabet2,origMsg,decrMsg);
}

function decryptUnknown1Key() {
    var alpha = "abcdefghijklmnopqrstuvwxyz";
    var origMsg = document.getElementById("message").value;
    var lowerMsg = origMsg.toLowerCase();
    var decrMsg;
    var currChar;
    var idxChar;
    var newChar;
    var key1;
    var ctr;
    var bigrams = ["bk", "fq", "jc", "jt", "mj", "qh", "qx", "vj", "wz", "zh", "bq", "fv", "jd", "jv", "mq", "qj", "qy", "vk", "xb", "zj", "bx", "fx", "jf", "jw", "mx", "qk", "qz", "vm", "xg", "zn", "cb", "fz", "jg", "jx", "mz", "ql", "sx", "vn", "xj", "zq", "cf", "gq", "jh", "jy", "pq", "qm", "sz", "vp", "xk", "zr", "cg", "gv", "jk", "jz", "pv", "qn", "tq", "vq", "xv", "zs", "cj", "gx", "jl", "kq", "px", "qo", "tx", "vt", "xz", "zx", "cp", "hk", "jm", "kv", "qb", "qp", "vb", "vw", "yq", "cv", "hv", "jn", "kx", "qc", "qr", "vc", "vx", "yv", "cw", "hx", "jp", "kz", "qd", "qs", "vd", "vz", "yz", "cx", "hz", "jq", "lq", "qe", "qt", "vf", "wq", "zb", "dx", "iy", "jr", "lx", "qf", "qv", "vg", "wv", "zc", "fk", "jb", "js", "mg", "qg", "qw", "vh", "wx", "zg"];
    for (key1 = 0; key1<26;key1++){
        decrMsg = "";
	    var shiftedAlphabet = shiftAlpha(key1);
        for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		    currChar = lowerMsg.charAt(ctr);
		    idxChar = alpha.indexOf(currChar);
		    if(idxChar==-1){
			    decrMsg += currChar;
		    }
		    if (idxChar!=-1){
			    newChar = shiftedAlphabet.charAt(idxChar);
			    decrMsg += newChar;
		    }
	    }
        var bgCheck = 0;
        var bg;
        var bgIdx;
        /*change code to use a while loop to run while check equals 0, increase check if a bigram is present, run while check is 0*/
        for (bg = 0; bg<bigrams.length; bg++){
        bgIdx = decrMsg.indexOf(bigrams[bg]);
        if(bgIdx != -1){
            bgCheck++;
            }
        }
        if (bgCheck == 0){
            oneKeyDecrDisplayUk(shiftedAlphabet,origMsg,decrMsg,26-key1);
        }
    }
}

function decryptUnknown2Key() {
    var alpha = "abcdefghijklmnopqrstuvwxyz";
    var origMsg = document.getElementById("message").value;
    var lowerMsg = origMsg.toLowerCase();
    var decrMsg;
    var currChar;
    var idxChar;
    var newChar;
    var key1;
    var key2;
    var ctr;
    var bigrams = ["bk", "fq", "jc", "jt", "mj", "qh", "qx", "vj", "wz", "zh", "bq", "fv", "jd", "jv", "mq", "qj", "qy", "vk", "xb", "zj", "bx", "fx", "jf", "jw", "mx", "qk", "qz", "vm", "xg", "zn", "cb", "fz", "jg", "jx", "mz", "ql", "sx", "vn", "xj", "zq", "cf", "gq", "jh", "jy", "pq", "qm", "sz", "vp", "xk", "zr", "cg", "gv", "jk", "jz", "pv", "qn", "tq", "vq", "xv", "zs", "cj", "gx", "jl", "kq", "px", "qo", "tx", "vt", "xz", "zx", "cp", "hk", "jm", "kv", "qb", "qp", "vb", "vw", "yq", "cv", "hv", "jn", "kx", "qc", "qr", "vc", "vx", "yv", "cw", "hx", "jp", "kz", "qd", "qs", "vd", "vz", "yz", "cx", "hz", "jq", "lq", "qe", "qt", "vf", "wq", "zb", "dx", "iy", "jr", "lx", "qf", "qv", "vg", "wv", "zc", "fk", "jb", "js", "mg", "qg", "qw", "vh", "wx", "zg"];
    for (key1 = 0; key1<26;key1++){
        for (key2 = 0; key2 < 26; key2++){
            decrMsg = "";
	        var key1 = document.getElementById("keyone").value;
	        var key2 = document.getElementById("keytwo").value;
	        var shiftedAlphabet1 = shiftAlpha(key1);
	        var shiftedAlphabet2 = shiftAlpha(key2);
            for (ctr = 0; ctr < lowerMsg.length; ctr+=1){
		        currChar = lowerMsg.charAt(ctr);
		        idxChar = alpha.indexOf(currChar);
		        if(idxChar==-1){
                    if(ctr % 2 == 0){
				    newChar = shiftedAlphabet1.charAt(idxChar);
				    decrMsg += newChar;
			        }
			        if(ctr % 2 == 1){
				        newChar = shiftedAlphabet2.charAt(idxChar);
				        decrMsg += newChar;
			        }
			        decrMsg += currChar;
		        }
		        if (idxChar!=-1){
			        if(ctr % 2 == 0){
				        newChar = shiftedAlphabet1.charAt(idxChar);
				        decrMsg += newChar;
			        }
			        if(ctr % 2 == 1){
				        newChar = shiftedAlphabet2.charAt(idxChar);
				        decrMsg += newChar;
			        }
		        }
	        }
            var bgCheck = 0;
            var bg;
            var bgIdx;
            for (bg = 0; bg<bigrams.length; bg++){
                bgIdx = decrMsg.indexOf(bigrams[bg]);
                if(bgIdx != -1){
                    //bgCheck++;
                    break;
                }
            }
            if (bgCheck == 0){
                twoKeyDecrDisplayUk(shiftedAlphabet1,shiftedAlphabet2,origMsg,decrMsg,26-key1,26-key2);
            }
        }
    }
}
