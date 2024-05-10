package com.example.borrowbee.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.borrowbee.data.entities.BranchEntity

@Dao
interface BranchDao {
    @Query("SELECT * FROM branches")
    fun getAllBranches(): List<BranchEntity>

    @Query("SELECT * FROM branches WHERE branch_id = :branchId")
    fun getBranchById(branchId: Long): BranchEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBranch(branch: BranchEntity)

    @Delete
    fun deleteBranch(branch: BranchEntity)
}