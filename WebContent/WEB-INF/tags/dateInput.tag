<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="cls" required="false"%>
<%@ attribute name="valDate" required="false" %>
<%@ attribute name="placeH" required="false" %>

<input id="${id}" name="${id}" class="${cls}" value="${valDate}" placeholder="${placeH}"/>
<script>
  $("#${id}").datepicker({
    dateFormat : 'dd/mm/yy'
  });

  $('#${id}').val(function(){
    var months = {
        Jan : "01",
        Feb : "02",
        Mar : "03",
        Apr : "04",
        May : "05",
        Jun : "06",
        Jul : "07",
        Aug : "08",
        Sep : "09",
        Oct : "10",
        Nov : "11",
        Dec : "12" };

    var dateFull = "${valDate}";

    if (dateFull.length == 0){

      return "";

    }

    var dd = dateFull.substring(8,10),
        mm = dateFull.substring(4,7),
        yyyy = dateFull.substring(24,28);

        return dd + "/" + months[mm] + "/" + yyyy;
  });
</script>
