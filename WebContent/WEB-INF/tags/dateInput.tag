<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="cls" required="false"%>

<input id="${id}" name="${id}" class="${cls}"/>
<script>
  $("#${id}").datepicker({
    dateFormat : 'dd/mm/yy'
  });
</script>
