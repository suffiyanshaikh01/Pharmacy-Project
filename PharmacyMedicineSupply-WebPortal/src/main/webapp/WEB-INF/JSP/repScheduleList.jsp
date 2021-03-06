<%@ include file="common/header.jspf"%>


<article>
	<div class="container">
		<h1 class="article-heading text-center m-4">Schedule</h1>
		<p style="color: red;text-align: center;">${createScheduleErrorMessage}</p>
		<c:if test="${empty createScheduleErrorMessage}">
		
		<table class="table table-striped table-bordered bg-light rounded">
			<thead style="background: #233e8b;">
			<tr class="text-center text-white"
				style="font-size: 1.3em;	">
				<th style="vertical-align: middle;">Representative Name</th>
				<th style="vertical-align: middle;">Doctor name</th>
				<th style="vertical-align: middle;">Treating Ailment</th>
				<th style="vertical-align: middle;">Medicine</th>
				<th style="vertical-align: middle;width:130px">Meeting Slot</th>
				<th style="vertical-align: middle;width:130px">Date Of Meeting</th>
				<th style="vertical-align: middle;width:130px">Doctor Contact No</th>
			</tr>
			</thead>
			<c:forEach items="${scheduleList}" var="repSchedule">
				<tr>
					<td>${repSchedule.repName}</td>
					<td>${repSchedule.docName}</td>
					<td>${repSchedule.teatingAilment}</td>
					<td>${repSchedule.medicineName}</td>
					<td>${repSchedule.slot}</td>
					<td>${repSchedule.date}</td>
					<td>${repSchedule.docContactNumber}</td>
				</tr>

			</c:forEach>

		</table>
		</c:if>
	</div>
</article>


<%@ include file="common/footer.jspf"%>