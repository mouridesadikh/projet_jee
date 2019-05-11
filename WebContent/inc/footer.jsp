
 


   <script src="${pageContext.request.contextPath}/assets/js/app.js"></script>

    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.1.min.js" ></script>
    <script src="${pageContext.request.contextPath}/assets/js/addons/datatables.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-table.js"></script>
      <script type="text/javascript">

  $(document).ready(function () {
	  $('#dtBasicExample').DataTable({
		    "paging": true // false to disable pagination (or any other option)
		  });

	  $('.dataTables_length').addClass('bs-select');
	  
	});
  $(function () {
      $('#hover, #striped, #condensed').click(function () {
          var classes = 'table';

          if ($('#hover').prop('checked')) {
              classes += ' table-hover';
          }
          if ($('#condensed').prop('checked')) {
              classes += ' table-condensed';
          }
          $('#table-style').bootstrapTable('destroy')
              .bootstrapTable({
                  classes: classes,
                  striped: $('#striped').prop('checked')
              });
      });
  });


  function rowStyle(row, index) {
      var classes = ['active', 'success', 'info', 'warning', 'danger'];

      if (index % 2 === 0 && index / 2 < classes.length) {
          return {
              classes: classes[index / 2]
          };
      }
      return {};
  }
  !function ($) {
      $(document).on("click","ul.nav li.parent > a > span.icon", function(){        
          $(this).find('em:first').toggleClass("glyphicon-minus");      
      }); 
      $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
  }(window.jQuery);

  $(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
  });
  $(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
  })
  

   </script>
</body>
</html>
 