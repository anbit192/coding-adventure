using Microsoft.OpenApi.Models;
using PizzaStore.DB;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen(c =>
{
    c.SwaggerDoc("v1", new OpenApiInfo { Title = "PizzaStore API", Description = "Making the Pizzas you love", Version = "v1" });
});


var app = builder.Build();

if (app.Environment.IsDevelopment())
{
   app.UseSwagger();
   app.UseSwaggerUI(c =>
   {
      c.SwaggerEndpoint("/swagger/v1/swagger.json", "PizzaStore API V1");
   });
}


builder.Services.AddEndpointsApiExplorer();

app.MapGet("/", () => "Hello World!");

app.MapGet("/pizza", () => PizzaDB.GetPizzas());
app.MapGet("/pizza/{id}", (int id) => PizzaDB.GetPizza(id));

app.MapPost("/pizza", (Pizza p) => PizzaDB.CreatePizza(p));

app.MapPut("/pizza", (Pizza p) => PizzaDB.UpdatePizza(p));

app.MapDelete("/pizza", (int id) => PizzaDB.RemovePizza(id));

app.Run();
