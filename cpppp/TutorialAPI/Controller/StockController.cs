using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TutorialAPI.Data;
using TutorialAPI.DTOs.Stock;
using TutorialAPI.Interfaces;
using TutorialAPI.Mappers;
using TutorialAPI.Models;

namespace TutorialAPI.Controller {
    [Route("api/stock")]
    [ApiController]
    public class StockController : ControllerBase {
        private readonly ApplicationDBContext _context;
        private readonly IStockRepository _stockRepo;
        public StockController(ApplicationDBContext context, IStockRepository stockRepo) {
            this._context = context;
            this._stockRepo = stockRepo;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll() {
            var stocks = await this._stockRepo.GetAllAsync();
            var stocksDTO = stocks.Select(x => x.ToStockDTO());
            return Ok(stocks);
        }

        [HttpGet("{id:int}")]
        public async Task<IActionResult> GetById([FromRoute] int id) {
            var stock = await this._context.Stocks.FindAsync(id);
            if (stock == null) {
                return NotFound();
            }

            return Ok(stock.ToStockDTO());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateStockRequestDTO stockDTO) {
            Stock stock = stockDTO.ToStockFromCreateDTO();
            await this._context.Stocks.AddAsync(stock);
            await this._context.SaveChangesAsync();

            return CreatedAtAction(nameof(GetById), new { id = stock.Id },
                                   stock.ToStockDTO());
        }

        [HttpPut("{id:int}")]
        public async Task<IActionResult> Update([FromRoute] int id,
                                    [FromBody] UpdateStockRequestDTO stockDTO) {
            var stock = await this._context.Stocks.FirstOrDefaultAsync(x => x.Id == id);
            if (stock == null) {
                return NotFound();
            }

            stock.Symbol = stockDTO.Symbol;
            stock.CompanyName = stockDTO.CompanyName;
            stock.Purchase = stockDTO.Purchase;
            stock.LastDiv = stockDTO.LastDiv;
            stock.Industry = stockDTO.Industry;
            stock.MarketCap = stockDTO.MarketCap;

            await this._context.SaveChangesAsync();

            return NoContent();
        }

        [HttpDelete("{id:int}")]
        public async Task<IActionResult> Delete([FromRoute] int id) {
            var stock = await this._context.Stocks.FirstOrDefaultAsync(x => x.Id == id);
            if (stock == null) {
                return NotFound();
            }

            this._context.Stocks.Remove(stock);
            await this._context.SaveChangesAsync();

            return NoContent();
        }
    }

}