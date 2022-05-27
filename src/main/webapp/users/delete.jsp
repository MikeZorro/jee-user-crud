<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Mike's user management system</h1>
        <a href="<c:url value="/user/list"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i> User List</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"> Delete User</h6>
        </div>
        <div class="card-body">
            <h3>Are you sure you want to delete user ${user.userName}</h3>
            <form method="post">
                <input type="hidden" name="id" value="${user.id}"/>
                <button type="submit" class="btn btn-primary" name ="decision" value="yes">YES</button>
                <button type="submit" class="btn btn-primary" name="decision" value="no">NO</button>
            </form>

        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>