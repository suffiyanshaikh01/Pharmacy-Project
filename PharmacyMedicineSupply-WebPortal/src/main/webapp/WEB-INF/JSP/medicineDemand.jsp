

<%@ include file="common/header.jspf"%>

<article>
	<div class="container">
		<h1 class="text-center m-4">Place Order</h1>

		<div class="w-50 p-3 mx-auto border rounded text-center card text-dark border-dark mb-3">
			<div>
				<img class="card-img-top"
					src="https://www.glbc.com/wp-content/uploads/2017/07/Place-order.png"
					alt="img place order"
					style="height:15rem; width: 18rem;">
			</div>
			<div class="card-body">
				<h3 class="card-title">Enter details</h3>
				<p class="card-text">Fill in the required details below.</p>

			</div>
			<div>
				<form method="post">
					<div class="form-group row">
						<label for="medicineName" class="col-sm-3 col-form-label">Medicine</label>
						<div class="col-sm-9">

							<select id="medicineName" class="form-control" name="medicineName" style="float: left">
								<c:forEach items="${medicineStockList}" var="obj">
									<option value=${obj.medicineName}>${obj.medicineName}</option>
								</c:forEach>
							</select>

						</div>
					</div>
					<div class="form-group row">
						<label for="demandCount" class="col-sm-3 col-form-label">Demand
							Count</label>
						<div class="col-sm-9">
							<input type="number" class="form-control" id="demandCount"
								name="demandCount" placeholder="Enter value" min="1"
								required="required">
						</div>
					</div>

					<input type="submit" class="btn btn-primary" name="submit"
						value="Submit">
				</form>
			</div>
		</div>

	</div>
</article>

<%@ include file="common/footer.jspf"%>