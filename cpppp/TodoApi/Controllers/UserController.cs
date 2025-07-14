using TodoAPI.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;
using System.Data;

namespace TodoAPI.Controllers;

[Route("api/[Controller]")]
[ApiController]
public class UserController : ControllerBase
{

    public readonly TodoContext _context;

    public UserController(TodoContext context)
    {
        this._context = context;
    }

    [HttpGet]
    public async Task<ActionResult<IEnumerable<UserDTO>>> GetUsers()
    {
        return await _context.Users.Select(OriginalEntity => EntityToDTO(OriginalEntity)).ToListAsync();
    }


    [HttpGet("{id}")]
    public async Task<ActionResult<UserDTO>> GetUser(int id)
    {
        var user = await _context.Users.FindAsync(id);
        if (user == null)
        {
            return NotFound();
        }

        return EntityToDTO(user);
    }

    [HttpPost]
    public async Task<ActionResult<UserDTO>> CreateUser(UserDTO userDTO)
    {
        var user = new User
        {
            Id = userDTO.Id,
            Name = userDTO.Name
        };

        _context.Users.Add(user);
        await _context.SaveChangesAsync();

        System.Console.WriteLine(nameof(GetUser));

        return CreatedAtAction(nameof(GetUser), new { id = user.Id }, EntityToDTO(user));
    }


    [HttpPut("{id}")]
    public async Task<IActionResult> UpdateUser(UserDTO userDTO, int id)
    {
        if (id != userDTO.Id)
        {
            return BadRequest();
        }

        var user = await _context.Users.FindAsync(id);
        if (user == null)
        {
            return NotFound();
        }

        user.Name = userDTO.Name;

        try
        {
            await _context.SaveChangesAsync();
        }
        catch (DBConcurrencyException) when (!EntityExist(id))
        {
            if (!EntityExist(id))
            {
                return NotFound();
            }
            else
            {
                throw;
            }
        }
        return NoContent();
    }

    [HttpDelete("{id}")]
    public async Task<IActionResult> RemoveUser(int id)
    {
        var user = await _context.Users.FindAsync(id);
        if (user == null)
        {
            return NotFound();
        }

        _context.Users.Remove(user);
        await _context.SaveChangesAsync();

        return NoContent();
    }

    private static UserDTO EntityToDTO(User user)
    {
        return new UserDTO
        {
            Id = user.Id,
            Name = user.Name
        };
    }

    private bool EntityExist(int id) {
        return _context.Users.Any(u => u.Id == id);
    }

}