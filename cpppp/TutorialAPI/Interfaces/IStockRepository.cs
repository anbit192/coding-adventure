using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TutorialAPI.DTOs.Stock;
using TutorialAPI.Models;

namespace TutorialAPI.Interfaces
{
    public interface IStockRepository {
        Task<List<Stock>> GetAllAsync();
        Task<Stock?> GetByIdAsync(int id);
        Task<Stock> CreateAsync(CreateStockRequestDTO stock);
        void UpdateAsync(int id, UpdateStockRequestDTO stockDTO);
        void Delete(int id);
    }
}