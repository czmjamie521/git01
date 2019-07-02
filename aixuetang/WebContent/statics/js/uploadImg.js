 $('#file-selector').change(function(){
		      var $file = $(this);
		      var fileObj = $file[0];
		      var windowURL = window.URL || window.webkitURL;
		      var dataURL;
		      var $img = $("#ig");
		      if (fileObj && fileObj.files && fileObj.files[0]) {
		          dataURL = windowURL.createObjectURL(fileObj.files[0]);
		          $img.attr('src', dataURL);
		      } else {
		          dataURL = $file.val();
		          var imgObj = document.getElementById("preview");
		          imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
		          imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;
		      }
		    });