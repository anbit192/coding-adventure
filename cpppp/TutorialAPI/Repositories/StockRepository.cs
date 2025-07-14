using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.EntityFrameworkCore;
using TutorialAPI.Data;
using TutorialAPI.DTOs.Stock;
using TutorialAPI.Interfaces;
using TutorialAPI.Models;

namespace TutorialAPI.Repositories {
    public class StockRepository : IStockRepository {
        private readonly ApplicationDBContext _context;
        public StockRepository(ApplicationDBContext context) {
            this._context = context;
        }

        public Task<Stock> CreateAsync(CreateStockRequestDTO stockDTO) {
            throw new NotImplementedException();
        }

        public void Delete(int id) {
            throw new NotImplementedException();
        }

        public Task<List<Stock>> GetAllAsync() {
            return this._context.Stocks.ToListAsync();
        }

        public async Task<Stock?> GetByIdAsync(int id) {
            var stock = await this._context.Stocks.FirstOrDefaultAsync(x => x.Id == id);
            if (stock == null) {
                return null;
            }

            return stock;
        }


        public void UpdateAsync(int id, UpdateStockRequestDTO stockDTO) {
            throw new NotImplementedException();
        }
    }
}