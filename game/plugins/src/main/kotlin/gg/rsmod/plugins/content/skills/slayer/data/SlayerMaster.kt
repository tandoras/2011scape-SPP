package gg.rsmod.plugins.content.skills.slayer.data

import gg.rsmod.game.model.combat.SlayerAssignment
import gg.rsmod.plugins.api.Skills
import gg.rsmod.plugins.api.cfg.*
import gg.rsmod.plugins.content.quests.Quest

/**
 * @author Alycia <https://github.com/alycii>
 */
class SlayerData(private val assignmentsByMaster: Map<SlayerMaster, List<Assignment>>) {
    fun getAssignmentsForMaster(master: SlayerMaster): List<Assignment> {
        return assignmentsByMaster[master] ?: emptyList()
    }
}

data class Assignment(
    val assignment: SlayerAssignment,
    val amount: IntRange = 0..0,
    val requirement: List<Requirement> = emptyList()
)

enum class SlayerMaster(val id: Int, val identifier: String, val defaultAmount: IntRange) {
    TURAEL(Npcs.TURAEL, identifier = "Turael", defaultAmount = 15..50),
    VANNAKA(Npcs.VANNAKA, identifier = "Vannaka", defaultAmount = 60..120),
    MAZCHNA(Npcs.MAZCHNA, identifier = "Mazchna", defaultAmount = 40..70),
}

// TODO: Note, I only added data for monsters that we currently have definitions for.
//TODO: We will also need to add weights so some tasks occur more frequently than others.
val slayerData = SlayerData(
    mapOf(
        SlayerMaster.TURAEL to listOf(
            //Assignment(assignment = SlayerAssignment.BANSHEE),
            Assignment(assignment = SlayerAssignment.BAT),
            Assignment(assignment = SlayerAssignment.BIRD),
            Assignment(assignment = SlayerAssignment.BEAR),
            Assignment(
                assignment = SlayerAssignment.CAVE_BUG,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 7)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CAVE_SLIME,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 17)
                )
            ),
            Assignment(assignment = SlayerAssignment.COW),
            // Assignment(assignment = SlayerAssignment.CRAWLING_HAND),
            // Assignment(assignment = SlayerAssignment.DESERT_LIZARD),
            // Assignment(assignment = SlayerAssignment.DOG),
            Assignment(assignment = SlayerAssignment.DWARF),
            Assignment(assignment = SlayerAssignment.GHOST),
            Assignment(assignment = SlayerAssignment.GOBLIN),
            // Assignment(assignment = SlayerAssignment.ICEFIEND, amount = 10..20),
            // Assignment(assignment = SlayerAssignment.MINOTAUR),
            // Assignment(assignment = SlayerAssignment.MONKEY),
            Assignment(assignment = SlayerAssignment.SCORPION),
            Assignment(assignment = SlayerAssignment.SKELETON),
            Assignment(assignment = SlayerAssignment.SPIDER),
            Assignment(assignment = SlayerAssignment.WOLF),
            Assignment(assignment = SlayerAssignment.ZOMBIE),
        ),
        SlayerMaster.VANNAKA to listOf(
            Assignment(
                assignment = SlayerAssignment.COCKATRICE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 25),
                    SkillRequirement(skill = Skills.DEFENCE, level = 20),
                )
            ),
            // TODO: have this require dragon slayer
            Assignment(
                assignment = SlayerAssignment.GREEN_DRAGON,
                requirement = listOf(
                    QuestPointRequirement(points = Quest.quests.sumOf { it.pointReward })
                )
            ),
            Assignment(assignment = SlayerAssignment.HILL_GIANT),
            Assignment(assignment = SlayerAssignment.LESSER_DEMON),
            Assignment(assignment = SlayerAssignment.MOSS_GIANT),
            Assignment(
                assignment = SlayerAssignment.PYREFIEND,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 30)
                )
            ),
            Assignment(assignment = SlayerAssignment.ICE_WARRIOR),
            Assignment(assignment = SlayerAssignment.ICE_GIANT),

            // TODO: these are filler tasks until Morytania is unlocked
            Assignment(assignment = SlayerAssignment.ROCK_SLUG),
            Assignment(
                assignment = SlayerAssignment.CAVE_BUG,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 7)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CAVE_SLIME,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 17)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CAVE_CRAWLER,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 10)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CRAWLING_HAND,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 5)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.BANSHEE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 15)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.INFERNAL_MAGE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 45)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.BLOODVELD,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 50)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.ABERRANT_SPECTRE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 60)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.GARGOYLE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 75)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.NECHRYAEL,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 80)
                )
            ),
            Assignment(
                assignment = SlayerAssignment.ABYSSAL_DEMON,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 85)
                )
            ),
            Assignment(assignment = SlayerAssignment.ZOMBIE)
        ),
        SlayerMaster.MAZCHNA to listOf(
            Assignment(
                assignment = SlayerAssignment.BANSHEE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 15),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.BAT,
            ),
            Assignment(
                assignment = SlayerAssignment.BEAR,
            ),
            // TODO: Add Catablepon
            Assignment(
                assignment = SlayerAssignment.CAVE_CRAWLER,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 10),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CAVE_SLIME,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 17),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.COCKATRICE,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 25),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.CRAWLING_HAND,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 5),
                )
            ),
            // TODO: Add Cyclopes
            // TODO: Add Desert Lizard
            // TODO: Add Dog
            // TODO: Add Flesh Crawler
            Assignment(
                assignment = SlayerAssignment.GHOUL
            ),
            Assignment(
                assignment = SlayerAssignment.GHOST
            ),
            Assignment(
                assignment = SlayerAssignment.HILL_GIANT
            ),
            // TODO: Add Hobgoblin
            Assignment(
                assignment = SlayerAssignment.ICE_WARRIOR
            ),
            // TODO: Add Kalphite
            // TODO: Add Mogre
            Assignment(
                assignment = SlayerAssignment.PYREFIEND,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 30),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.ROCK_SLUG,
                requirement = listOf(
                    SkillRequirement(skill = Skills.SLAYER, level = 20),
                )
            ),
            Assignment(
                assignment = SlayerAssignment.SKELETON
            ),
            // TODO: Add Vampyre
            // TODO: Add Wallbeast
            Assignment(
                assignment = SlayerAssignment.WOLF,
            ),
            Assignment(
                assignment = SlayerAssignment.ZOMBIE,
            ),
        ),
    )
)