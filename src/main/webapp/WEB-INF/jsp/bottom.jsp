</body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<script>
    var contextPath = "${contextPath}";
</script>

<script src="${contextPath}/lib/jquery-2.1.3.min.js"></script>
<script src="${contextPath}/lib/knockout-3.3.0.js"></script>
<script src="${contextPath}/js/add-order.js"></script>

</html>