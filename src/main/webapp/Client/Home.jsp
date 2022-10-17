<%--
  Created by IntelliJ IDEA.
  User: abderrahmane
  Date: 10/16/2022
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="w-full max-w-xs">
    <form class="bg-white shadow-md rounded px-8 pt-6 pb-8 mb-4"
          action="${pageContext.request.contextPath}/search-for-flights" method="get">
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="departure-city">
                Departure city
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="departure-city" id="departure-city" type="text" placeholder="e.g: Casablanca">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="arrival-city">
                Arrival city
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="arrival-city" id="arrival-city" type="text" placeholder="e.g: Paris">
        </div>
        <div class="mb-4">
            <label class="block text-gray-700 text-sm font-bold mb-2" for="flight-date">
                Flight date
            </label>
            <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                   name="flight-date" id="flight-date" type="date">
        </div>
        <div class="flex items-center justify-between">
            <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                    type="submit">
                Search
            </button>
        </div>
    </form>
</div>
</body>
</html>
